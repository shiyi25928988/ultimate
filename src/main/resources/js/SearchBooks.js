
$(document).ready(function() {
    $('#busyIndicator').hide();
    $('#search').on('keypress', function(event) {
        if (event.which === 13) { // 13 是回车键的键码
            event.preventDefault(); // 阻止默认行为（如表单提交）
            searchBooks();
        }
    });
});

function searchBooks() {
    $('#busyIndicator').show();
    var query = $('#search').val();
    if(query.length != 0){
        performSearch(query);
    }
}

function performSearch(query) {
    $.ajax({
        url: '/api/books/getBooksDivByName?bookname=' + query,
        type: 'GET',
        success: function(response) {
            console.log('Search results:', response);
            updateBookCards(response);
        },
        error: function(xhr, status, error) {
            console.error('Search error:', error);
        },
        complete: function() {
            $('#busyIndicator').hide();
        }
    });
}

function updateBookCards(response) {
    var container = $('#bookContainer');
    container.empty();
    container.append(response.data);
}
