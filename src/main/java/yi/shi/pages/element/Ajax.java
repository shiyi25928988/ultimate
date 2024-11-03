package yi.shi.pages.element;

public class Ajax {

    public static String getAjax(String url, String data){
        String ajax = "$.ajax({\n" +
                "    url: '" + url + "',\n" +
                "    method: 'POST',\n" +
                "    data: JSON.stringify(" + data + "),\n" +
                "    success: function(response) {\n" +
                "        if (response.code === 1) {\n" +
                "            Toastify({\n" +
                "                text: response.message,\n" +
                "                duration: 3000,\n" +
                "                close: true,\n" +
                "                gravity: 'top',\n" +
                "                position: 'center',\n" +
                "                backgroundColor: '#4caf50',\n" +
                "                stopOnFocus: true\n" +
                "             }).showToast();\n" +
                "        } else if (response.code === 0) {\n" +
                "             Toastify({\n" +
                "                 text: response.message,\n" +
                "                 duration: 3000,\n" +
                "                 close: true,\n" +
                "                 gravity: 'top',\n" +
                "                 position: 'center',\n" +
                "                 backgroundColor: '#f44336',\n" +
                "                 stopOnFocus: true\n" +
                "             }).showToast();\n" +
                "        }\n" +
                "    },\n" +
                "    error: function(xhr, status, error) {\n" +
                "             Toastify({\n" +
                "                 text: xhr.statusText,\n" +
                "                 duration: 3000,\n" +
                "                 close: true,\n" +
                "                 gravity: 'top',\n" +
                "                 position: 'center',\n" +
                "                 backgroundColor: '#f44336',\n" +
                "                 stopOnFocus: true\n" +
                "             }).showToast();\n" +
                "        console.error('请求失败:', error);\n" +
                "    }\n" +
                "});";
        return ajax;
    }
}
