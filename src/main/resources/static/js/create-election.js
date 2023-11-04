const submitButton = document.getElementById("add-election-submit");
const electionNameInput = document.getElementById("electionName");
const electionStartDateTime = document.getElementById("electionStartDate");
const electionEndDateTime = document.getElementById("electionEndDate");

const url = "/api/election";

const submitAddForm = () => {
    const electionName = electionNameInput.value;
    const electionStart = electionStartDateTime.value;
    const electionEnd = electionEndDateTime.value;
    if (electionName && electionStart && electionEnd) {
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify({
                "electionName": electionName,
                "electionStartDate": electionStart,
                "electionEndDate": electionEnd
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                if (data.statusCode == 201){
                    electionNameInput.value = "";
                    electionStartDateTime.value = "";
                    electionEndDateTime.value = "";
                    Swal.fire({
                        title: 'Success!',
                        text: data.message,
                        icon: 'success',
                        confirmButtonText: 'Ok'
                    })
                }else{
                    Swal.fire({
                        title: 'Error!',
                        text: data.message,
                        icon: 'error',
                        confirmButtonText: 'ok'
                    })
                }
            },
            error: function (errMsg) {
                const errors = errMsg.responseJSON.data;
                const errorDetails =Object.entries(errors).map(([field, message]) => `${field}: ${message}`)
                    .join('<br>');
                Swal.fire({
                    title: 'Error!',
                    text: errorDetails,
                    icon: 'error',
                    confirmButtonText: 'Cool'
                })
            }
        });
    }
};

submitButton.addEventListener("click", function (e){
    e.preventDefault();
    submitAddForm();
});