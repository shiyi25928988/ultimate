
function addNewBook() {
    var bookData = {
        bookName: $('#bookName').val(),
        isbn: $('#isbn').val(),
        digest: $('#digest').val(),
        author: $('#author').val(),
        aboutAuthor: $('#aboutAuthor').val(),
        price: $('#price').val(),
        coverUrl: $('#coverUrl').val(),
    };
    $.ajax({
        url: '/api/books/addBooks',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(bookData),
        success: function(response) {
            alert('图书信息新增成功！');
        },
        error: function(xhr, status, error) {
            alert('图书信息新增失败: ' + error);
        }
    });
}