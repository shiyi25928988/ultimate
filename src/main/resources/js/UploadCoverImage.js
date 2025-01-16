document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
});

function uploadFile() {
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];
    var formData = new FormData();
    formData.append('file', file);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/api/upload');
    xhr.onreadystatechange = function() {
    debugger;
        if (xhr.readyState === 4 && xhr.status === 200) {
            alert('上传成功');
        }
    };
//    if (file) {
//        var formData = new FormData();
//        formData.append('file', file);
//        fetch('/api/upload', {
//            method: 'POST',
//            body: formData
//        })
//        .then(response => {
//            debugger;
//            //alert('上传成功');
//            console.log(response.json());
//        })
//        .then(data => {
//            debugger;
//            //alert('上传成功');
//            console.log('Success:', data);
//        })
//        .catch((error) => {
//            console.error('Error:', error);
//        });
//    } else {
//        alert('请选择一个文件');
//    }
}

function handleFileUpload(event) {
    event.preventDefault();

    const fileInput = document.getElementById('fileInput');
    const progressBar = document.querySelector('.determinate');

    if (!fileInput.files.length) {
        M.toast({html: '请选择文件'});
        return;
    }

    const file = fileInput.files[0];
    const formData = new FormData();
    formData.append('file', file);

    // 创建 XMLHttpRequest 对象
    const xhr = new XMLHttpRequest();

    // 监听上传进度
    xhr.upload.addEventListener('progress', (event) => {
        if (event.lengthComputable) {
            const percentComplete = (event.loaded / event.total) * 100;
            progressBar.style.width = percentComplete + '%';
        }
    });

    // 处理上传完成
    xhr.onload = function() {

        if (xhr.status === 200) {
            try {
                const response = JSON.parse(xhr.responseText);
                if (response.code === 1) {
                    M.toast({html: '上传成功'});
                    // 重置进度条
                    progressBar.style.width = '0%';
                    // 清空文件输入
                    fileInput.value = '';
                    // 关闭模态框

                    debugger;
                    document.getElementById('coverUrl').value = response.data[0];

                    const modalInstance = M.Modal.getInstance(document.getElementById('uploadCoverImagemodal'));
                    modalInstance.close();

                    // 如果需要刷新特定内容而不是整个页面
                    // refreshContent();
                } else {
                    M.toast({
                        html: response.message || '上传失败',
                        class: 'red'
                    });
                }
            } catch (e) {
                M.toast({html: '服务器响应格式错误'});
            }
        } else {
            M.toast({html: '上传失败: ' + xhr.status});
        }
    };

    // 处理上传错误
    xhr.onerror = function() {
        M.toast({html: '上传出错，请检查网络连接'});
        progressBar.style.width = '0%';
    };

    // 发送请求
    xhr.open('POST', '/api/upload', true);
    xhr.send(formData);
}

// 可选：刷新特定内容的函数
function refreshContent() {
    // 这里添加刷新特定内容的逻辑
    // 例如通过 AJAX 获取新数据并更新页面特定部分
    fetch('/api/getUpdatedContent')
        .then(response => response.json())
        .then(data => {
            // 更新页面特定部分的内容
            // document.getElementById('contentArea').innerHTML = data.content;
        })
        .catch(error => {
            console.error('Error refreshing content:', error);
        });
}