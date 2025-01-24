package yi.shi.pages.component;

public class Ajax {

    public static String getAjax(String url, String data){
        String ajax = "$.ajax({\n" +
                "    url: '" + url + "',\n" +
                "    method: 'POST',\n" +
                "    data: JSON.stringify(" + data + "),\n" +
                "    success: function(response) {\n" +
                "        if (response.code === 1) {\n" +
                "            M.toast({\n" +
                "                html: response.message,\n" +
                "             });\n" +
                "        } else if (response.code === 0) {\n" +
                "             M.toast({\n" +
                "                 html: response.message,\n" +
                "             });\n" +
                "        }\n" +
                "    },\n" +
                "    error: function(xhr, status, error) {\n" +
                "             M.toast({\n" +
                "                 html: xhr.statusText,\n" +
                "             });\n" +
                "        console.error('请求失败:', error);\n" +
                "    }\n" +
                "});";
        return ajax;
    }
}
