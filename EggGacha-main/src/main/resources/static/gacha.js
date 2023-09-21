$(function () {
    $('#open-btn').click(function (event){
        $.getJSON(
            '/gacha/pets/',
            function (pet) {
                const reward = $('#reward');
                reward.append(
                    `<div class="ps-4 bg-warning bg-opacity-50 rounded">
                        <span class="me-2">${pet.rarity}</span>
                        <span class="me-2">${pet.name}</span>
                    </div>`
                )
            }
        );

        $.getJSON(
            '/gacha/pets/remain',
            function (remain) {
                const gacha = $('#gacha');
                if (remain > 0){
                    gacha.html(remain)
                }else {
                    gacha.html('Out of wish! buy more')
                }
            }
        );


    });
})