document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
});

function uploadFile() {
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];
    if (file) {
        var formData = new FormData();
        formData.append('file', file);
        fetch('/api/upload', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            alert('上传成功');
            response.json()
        })
        .then(data => {
            alert('上传成功');
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    } else {
        alert('请选择一个文件');
    }
}
