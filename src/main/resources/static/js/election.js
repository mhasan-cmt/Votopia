const electionWrapper = $('#elections-wrapper');
const url = "/api/election";
const loadElections = () => {
    $.get(url, function (data) {
        if (data.statusCode == 200 && data.data.length > 0) {
            data.data.forEach((election) => {
                let electionName = election.electionName;
                let electionStartDate = election.electionStartDate;
                let electionEndDate = election.electionEndDate;
                let electionStatus = election.status;

                let cardDiv = $('<div>').addClass('col-md-3');
                let card = $('<div>').addClass('card').css('width', '18rem');
                let image = $('<img>').attr('src', 'https://www.tbsnews.net/sites/default/files/styles/amp_metadata_content_image_min_696px_wide/public/images/2023/04/18/election_commission_0.jpg').addClass('card-img-top').attr('alt', '...');
                let cardBody = $('<div>').addClass('card-body');
                let title = $('<h5>').addClass('card-title').text(electionName);
                let voteStart = $('<p>').addClass('card-text text-center fw-bold').html('Vote Start Date: <br><span class="fw-light">' + electionStartDate + '</span>');
                let voteEndsIn = $('<p>').addClass('card-text text-center fw-bold').html('Vote End Date: <br><span class="fw-light">'+electionEndDate+'</span>');
                let status = $('<div>').addClass('border border-success text-center py-1 my-2').text(electionStatus);
                let editButton = $('<a>').attr('href', '#').addClass('btn btn-primary').text('Edit');

                card.append(image);
                cardBody.append(title, voteStart, voteEndsIn, status, editButton);
                card.append(cardBody);
                cardDiv.append(card);

                electionWrapper.append(cardDiv);
            });
        } else {
            Swal.fire({
                title: 'Error!',
                text: data.message,
                icon: 'error',
                confirmButtonText: 'ok'
            })
        }
    }).fail(function(xhr, status, error) {
        let errorResponse = JSON.parse(xhr.responseText);
        Swal.fire({
            title: 'Error!',
            text: errorResponse.message,
            icon: 'error',
            confirmButtonText: 'OK'
        });
    });

}

$(document).ready(function () {
    loadElections();
});