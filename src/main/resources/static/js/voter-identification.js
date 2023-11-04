const addVoterIdButton = document.getElementById("voter-add-submit");
const voterIdInput = document.getElementById("voter-id");
const voterAddModal = $('#add-voter-id-modal');
const voterIDTable = $('#verifications-table');
const url = "/api/voter-identification";
const submitAddForm = () => {
    const voterId = voterIdInput.value;
    if (voterId) {
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify({
                "idNumber": voterId
            }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                if (data.statusCode == 201){
                    voterIdInput.value = "";
                    voterAddModal.modal('hide');
                    Swal.fire({
                        title: 'Success!',
                        text: data.message,
                        icon: 'success',
                        confirmButtonText: 'Ok'
                    })
                    loadVoterIdentifications();
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
}
const loadVoterIdentifications = () => {
    $.get(url, function (data) {
        if (data.statusCode == 200 && data.data.length > 0) {
            const verificationsTable = document.getElementById("verifications-table");
            const tbody = verificationsTable.getElementsByTagName("tbody")[0];
            voterIDTable.DataTable().clear().destroy();
            data.data.forEach((voterId) => {
                const tr = document.createElement("tr");

                // Column 1: Index
                const indexCell = document.createElement("td");
                indexCell.textContent = data.data.indexOf(voterId) + 1;
                tr.appendChild(indexCell);

                // Column 2: Voter ID Number
                const idNumberCell = document.createElement("td");
                idNumberCell.textContent = voterId.idNumber;
                tr.appendChild(idNumberCell);

                // Column 3: Check for isRegistered and add icon based on the condition
                const isRegisteredCell = document.createElement("td");
                const icon = document.createElement("span");
                icon.classList.add("fa");
                if (voterId.isRegistered) {
                    icon.classList.add("fa-check-circle", "text-success");
                } else {
                    icon.classList.add("fa-times-circle", "text-danger");
                }
                isRegisteredCell.appendChild(icon);
                tr.appendChild(isRegisteredCell);

                tbody.appendChild(tr);
            });
            voterIDTable.DataTable();
        }
    });
};
addVoterIdButton.addEventListener("click", () => {
    submitAddForm();
});
voterAddModal.on('hidden.bs.modal', function () {
    voterIdInput.value = "";
});

$('document').ready(function () {
    voterIDTable.DataTable();
    loadVoterIdentifications();
});