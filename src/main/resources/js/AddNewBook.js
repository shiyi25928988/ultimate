$(document).ready(function() {
    $('#busyIndicator').hide();
    $('#bookName').focus();
});
function queryBookInfo() {
    var bookName = $('#bookName').val();
    if(bookName.length === 0){
        M.toast({
            html: '书名不能为空！',
        });
        return;
    }
    var api = '/api/AI/queryInfoByBookName?bookname=' + bookName;
    $('#busyIndicator').show();
    $.ajax({
        url: api,
        type: 'GET',
        success: function(response) {
            if (response.code === 1) {
                M.toast({
                    html: response.message,
                });
                $('#bookName').val(response.data.bookName);
                $('#bookName').focus();
                $('#isbn').val(response.data.isbn);
                $('#isbn').focus();
                $('#digest').val(response.data.digest);
                $('#digest').focus();
                $('#author').val(response.data.author);
                $('#author').focus();
                $('#aboutAuthor').val(response.data.aboutAuthor);
                $('#aboutAuthor').focus();
                $('#price').val(response.data.price);
                $('#price').focus();
                $('#coverUrl').val(response.data.coverUrl);
                $('#coverUrl').focus();
            } else if (response.code === 0) {
                M.toast({
                    html: '未查询到相关书籍信息',
                });
            }
        },
        error: function(xhr, status, error) {
            M.toast({
                html: xhr.statusText,
            });
        },
        complete: function() {
            $('#busyIndicator').hide();
        }
    });
}


function addNewBook() {
    var bookData = {
        bookName:    $('#bookName').val(),
        isbn:        $('#isbn').val(),
        digest:      $('#digest').val(),
        author:      $('#author').val(),
        aboutAuthor: $('#aboutAuthor').val(),
        price:       $('#price').val(),
        coverUrl:    $('#coverUrl').val(),
    };
    $('#busyIndicator').show();
    $.ajax({
        url: '/api/books/addBooks',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(bookData),
        success: function(response) {
            if (response.code === 1) {
                M.toast({
                    html: response.message,
                });
            } else if (response.code === 0) {
                M.toast({
                    html: response.message,
                });
            }
        },
        error: function(xhr, status, error) {
            M.toast({
                html: xhr.statusText,
            });
        },
        complete: function() {
            $('#busyIndicator').hide();
        }
    });
}