const addPostButton = document.getElementById("post-add-submit");
const postTitleInput = document.getElementById("post_name");
const postDescriptionInput = document.getElementById("post_description");
const postAddModal = $('#add-post-modal');
const postTable = $('#posts-table');
const url = "/api/post";

function loadPosts() {
    $.get(url, function (data){
        if (data.statusCode == 200 && data.data.length > 0){
            const postsTable = document.getElementById("posts-table");
            const tbody = postsTable.getElementsByTagName("tbody")[0];
            postTable.DataTable().clear().destroy();
            data.data.forEach((post) => {
                const tr = document.createElement("tr");

                // Column 1: Index
                const indexTd = document.createElement("td");
                indexTd.textContent = data.data.indexOf(post) + 1;
                tr.appendChild(indexTd);

                // Column 2: Post Name
                const postNameTd = document.createElement("td");
                postNameTd.innerText = post.postName;
                tr.appendChild(postNameTd);

                // Column 3: Description
                const descriptionTd = document.createElement("td");
                descriptionTd.innerText = post.description;
                tr.appendChild(descriptionTd);

                tbody.appendChild(tr);
            });
            postTable.DataTable();
        }
    }).fail(function (xhr, status, error){
        let errorResponse = JSON.parse(xhr.responseText);
        Swal.fire({
            title: 'Error!',
            text: errorResponse.message,
            icon: 'error',
            confirmButtonText: 'Ok'
        })

    });
}

const submitAddForm = () => {
    const postTitle = postTitleInput.value;
    const postDescription = postDescriptionInput.value;
    if (postTitle && postDescription){
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify({
                "postName": postTitle,
                "description": postDescription
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data){
                if (data.statusCode == 201) {
                    postTitleInput.value = "";
                    postDescriptionInput.value = "";
                    postAddModal.modal('hide');
                    Swal.fire({
                        title: 'Success!',
                        text: data.message,
                        icon: 'success',
                        confirmButtonText: 'Ok'
                    })
                    loadPosts();
                }else{
                    Swal.fire({
                        title: 'Error!',
                        text: data.message,
                        icon: 'error',
                        confirmButtonText: 'ok'
                    })
                }
            },
            error: function (errMsg){
                const errors = errMsg.responseJSON.message;
                console.log(errors);
                Swal.fire({
                    title: 'Error!',
                    text: errors,
                    icon: 'error',
                    confirmButtonText: 'Ok'
                })
            }
        })
    }

}
postAddModal.on('hidden.bs.modal', function () {
    postTitleInput.value = "";
    postDescriptionInput.value = "";
});

$(document).ready(function (){
    postTable.DataTable();
    loadPosts();
    addPostButton.addEventListener("click", submitAddForm);
});