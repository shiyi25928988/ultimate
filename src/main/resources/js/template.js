$(document).ready(function() {
    $('#busyIndicator').hide();
});

function template() {
    //do something
    var something = $('#something').val();
    var data = {
        something: something,
    };

    $('#busyIndicator').show();
    $.ajax({
        url: '/api/something',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            if (response.code === 1) {
                M.toast({
                    html: response.message,
                    classes: 'blue',
                    completeCallback: function() {
                        window.location.href = '/';
                    }
                });
            } else if (response.code === 0) {
                M.toast({
                    html: response.message,
                    classes: 'red',
                });
            }
        },
        error: function(xhr, status, error) {
            M.toast({
                html: xhr.statusText,
                classes: 'red',
            });
        },
        complete: function() {
            $('#busyIndicator').hide();
        }
    });
}