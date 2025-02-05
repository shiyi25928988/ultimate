document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
});

function handleFileUpload(event) {
    event.preventDefault();
    const fileInput = document.getElementById('fileInput');
    const progressBar = document.querySelector('.determinate');

    if (!fileInput.files.length) {
        M.toast({html: '请选择文件', classes: 'red'});
        return;
    }

    const file = fileInput.files[0];
    const formData = new FormData();
    formData.append('file', file);

    const xhr = new XMLHttpRequest();

    xhr.upload.addEventListener('progress', (event) => {
        if (event.lengthComputable) {
            const percentComplete = (event.loaded / event.total) * 100;
            progressBar.style.width = percentComplete + '%';
        }
    });

    xhr.onload = function() {
        if (xhr.status === 200) {
            try {
                const response = JSON.parse(xhr.responseText);
                if (response.code === 1) {
                    M.toast({html: '上传成功', classes: 'blue'});
                    progressBar.style.width = '0%';
                    fileInput.value = '';
                    document.getElementById('coverUrl').value = response.data[0];

                    const modalInstance = M.Modal.getInstance(document.getElementById('uploadCoverImagemodal'));
                    modalInstance.close();

                } else {
                    M.toast({
                        html: response.message || '上传失败',
                        classes: 'red'
                    });
                }
            } catch (e) {
                M.toast({html: '服务器响应格式错误', classes: 'red'});
            }
        } else {
            M.toast({html: '上传失败: ' + xhr.status, classes: 'red'});
        }
    };

    xhr.onerror = function() {
        M.toast({html: '上传出错，请检查网络连接', classes: 'red'});
        progressBar.style.width = '0%';
    };

    xhr.open('POST', '/api/upload', true);
    xhr.send(formData);
}
