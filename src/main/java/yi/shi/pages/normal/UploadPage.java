package yi.shi.pages.normal;

import j2html.tags.ContainerTag;
import j2html.tags.Tag;
import yi.shi.pages.component.Head;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class UploadPage {


    @GET
    @AUTH(authUrl = "/page/login", andRole = "admin")
    @HttpPath(value = "/page/uploadpage")
    public HTML uploadPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(page().render());
        return html;
    }

    /**
     * Generates a ContainerTag representing the page.
     *
     * @return The ContainerTag representing the page.
     */
    private Tag page(){
        ContainerTag html = html(
                Head.createHead("上传文件"),
                //Header.createHeader(),
                        style("body {\n" +
                                "                        font-family: Arial, sans-serif;\n" +
                                "                        background-color: #f4f4f4;\n" +
                                "                        margin: 0;\n" +
                                "                        padding: 0;\n" +
                                "                        display: flex;\n" +
                                "                        justify-content: center;\n" +
                                "                        align-items: center;\n" +
                                "                        height: 100vh;\n" +
                                "                        flex-direction: column;\n" +
                                "                    }\n" +
                                "                    .container {\n" +
                                "                        background-color: #fff;\n" +
                                "                        padding: 20px;\n" +
                                "                        border-radius: 8px;\n" +
                                "                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                                "                        text-align: center;\n" +
                                "                        max-width: 400px;\n" +
                                "                        width: 90%;\n" +
                                "                    }\n" +
                                "                    h1 {\n" +
                                "                        color: #333;\n" +
                                "                        margin-bottom: 20px;\n" +
                                "                    }\n" +
                                "                    label {\n" +
                                "                        display: block;\n" +
                                "                        margin-bottom: 10px;\n" +
                                "                        font-size: 18px;\n" +
                                "                    }\n" +
                                "                    input[type=\"file\"] {\n" +
                                "                        padding: 10px;\n" +
                                "                        border: 1px solid #ccc;\n" +
                                "                        border-radius: 4px;\n" +
                                "                        width: 100%;\n" +
                                "                        margin-bottom: 20px;\n" +
                                "                    }\n" +
                                "                    input[type=\"submit\"] {\n" +
                                "                        background-color: #007BFF;\n" +
                                "                        color: #fff;\n" +
                                "                        border: none;\n" +
                                "                        padding: 10px 20px;\n" +
                                "                        border-radius: 4px;\n" +
                                "                        cursor: pointer;\n" +
                                "                        font-size: 16px;\n" +
                                "                        width: 100%;\n" +
                                "                    }\n" +
                                "                    input[type=\"submit\"]:hover {\n" +
                                "                        background-color: #0056b3;\n" +
                                "                    }\n" +
                                "                    .progress-container {\n" +
                                "                        margin-top: 20px;\n" +
                                "                        width: 100%;\n" +
                                "                    }\n" +
                                "                    .progress-bar {\n" +
                                "                        height: 20px;\n" +
                                "                        background-color: #e0e0e0;\n" +
                                "                        border-radius: 10px;\n" +
                                "                        overflow: hidden;\n" +
                                "                    }\n" +
                                "                    .progress {\n" +
                                "                        height: 100%;\n" +
                                "                        width: 0;\n" +
                                "                        background-color: #4caf50;\n" +
                                "                        transition: width 0.5s;\n" +
                                "                    }\n" +
                                "                    @media (max-width: 600px) {\n" +
                                "                        body {\n" +
                                "                            padding: 20px;\n" +
                                "                        }\n" +
                                "                        .container {\n" +
                                "                            padding: 15px;\n" +
                                "                        }\n" +
                                "                        h1 {\n" +
                                "                            font-size: 24px;\n" +
                                "                        }\n" +
                                "                        label {\n" +
                                "                            font-size: 16px;\n" +
                                "                        }\n" +
                                "                        input[type=\"file\"], input[type=\"submit\"] {\n" +
                                "                            font-size: 14px;\n" +
                                "                        }\n" +
                                "                    }"),

                body(
                        div(
                                h3("上传文件"),
                                form(
                                        label("选择文件: "),
                                        input().withType("file").withName("file").withId("fileInput").withCondMultiple(true),
                                        br(),
                                        input().withType("submit").withValue("上传")
                                ).withMethod("post").withCondEnctype(true, "multipart/form-data").withAction("/upload").withId("uploadForm"),
                                div(
                                        div().withClass("progress-bar").with(div().withClass("progress"))
                                ).withClass("progress-container")
                        ).withClass("container"),
                        script("document.getElementById('uploadForm').addEventListener('submit', function(event) {\n" +
                                "                        event.preventDefault();\n" +
                                "                        const formData = new FormData(this);\n" +
                                "                        const progressBar = document.querySelector('.progress');\n" +
                                "                        const fileInput = document.getElementById('fileInput');\n" +
                                "\n" +
                                "                        const xhr = new XMLHttpRequest();\n" +
                                "                        xhr.open('POST', '/api/upload', true);\n" +
                                "                        xhr.upload.onprogress = function(event) {\n" +
                                "                            if (event.lengthComputable) {\n" +
                                "                                const percentCompleted = Math.round((event.loaded * 100) / event.total);\n" +
                                "                                progressBar.style.width = percentCompleted + '%';\n" +
                                "                            }\n" +
                                "                        };\n" +
                                "                        xhr.onload = function() {\n" +
                                "                            if (xhr.status === 200) {\n" +
                                "                                Toastify({\n" +
                                "                                    text: xhr.responseText,\n" +
                                "                                    duration: 3000,\n" +
                                "                                    close: true,\n" +
                                "                                    gravity: 'top',\n" +
                                "                                    position: 'center',\n" +
                                "                                    backgroundColor: '#4caf50',\n" +
                                "                                    stopOnFocus: true\n" +
                                "                                }).showToast();\n" +
                                "                                // 清空文件输入框\n" +
                                "                                fileInput.value = '';\n" +
                                "                                // 重置进度条\n" +
                                "                                progressBar.style.width = '0%';\n" +
                                "                            } else {\n" +
                                "                                Toastify({\n" +
                                "                                    text: '文件上传失败: ' + xhr.statusText,\n" +
                                "                                    duration: 3000,\n" +
                                "                                    close: true,\n" +
                                "                                    gravity: 'top',\n" +
                                "                                    position: 'center',\n" +
                                "                                    backgroundColor: '#f44336',\n" +
                                "                                    stopOnFocus: true\n" +
                                "                                }).showToast();\n" +
                                "                                // 重置进度条\n" +
                                "                                progressBar.style.width = '0%';\n" +
                                "                            }\n" +
                                "                        };\n" +
                                "                        xhr.onerror = function() {\n" +
                                "                            Toastify({\n" +
                                "                                text: '文件上传失败: ' + xhr.statusText,\n" +
                                "                                duration: 3000,\n" +
                                "                                close: true,\n" +
                                "                                gravity: 'top',\n" +
                                "                                position: 'center',\n" +
                                "                                backgroundColor: '#f44336',\n" +
                                "                                stopOnFocus: true\n" +
                                "                            }).showToast();\n" +
                                "                            // 重置进度条\n" +
                                "                            progressBar.style.width = '0%';\n" +
                                "                        };\n" +
                                "                        xhr.send(formData);\n" +
                                "                    });")
                )
        );


        return html;
    }
}
