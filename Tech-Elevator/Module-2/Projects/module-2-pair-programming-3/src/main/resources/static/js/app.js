const API_BASE = 'http://localhost:8080/api/cards';
let cardData = {};

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('save_btn').addEventListener('click', saveCard);
    document.getElementById('next_btn').addEventListener('click', getNewCard);

    refreshCollection();
    getNewCard();
});

function getNewCard() {
    const cat_fact = document.getElementById('cat_fact');
    const cat_pic = document.getElementById('cat_pic');
    const caption = document.getElementById('caption_box');

    fetch(API_BASE + '/random')
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            caption.value = '';
            caption.disabled = false;
            caption.style.textAlign = 'left';

            cardData = {};
            cardData['catFact'] = data.catFact;
            cardData['imgUrl'] = data.imgUrl;
            cat_fact.innerText = data.catFact;
            cat_pic.setAttribute('src', data.imgUrl);
            caption.focus();
        });
}

function saveCard() {
    const caption = document.getElementById('caption_box');
    caption.style.textAlign = 'center';
    caption.disabled = true;
    cardData['caption'] = caption.value;


    if( cardData.catCardId != undefined ) {
        // update
        fetch(API_BASE + '/' + cardData.catCardId, {
            method: 'PUT',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(cardData)
        })
            .then((response) => {
                if( response.ok ) {
                    alert('Saved!');
                    refreshCollection();
                }
            })
            .catch((err) => {
                console.error(err);
                alert('Could not save card!');
            });
    } else {
        // save
        fetch(API_BASE, {
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(cardData)
        })
            .then((response) => {
                if( response.ok ) {
                    alert('Saved!');
                    refreshCollection();
                }
            })
            .catch((err) => {
                console.error(err);
                alert('Could not save card!');
            });
    }



    getNewCard();
}

function refreshCollection() {
    //Tear it down
    const collection = document.getElementById('collection');
    while (collection.firstChild) {
        collection.firstChild.remove();
    }

    //Build it up
    fetch(API_BASE)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            data.forEach((card) => {
                const container = document.createElement('div');
                container.classList.add("card")
                addId(container, card.catCardId);
                //addFact(container, card.catFact);
                addPic(container, card.imgUrl);
                addCaption(container, card.caption);
                addIcons(container, card.catCardId);
                collection.appendChild(container);
            });
        });
}

function editHandler(event, id) {
    const cat_fact = document.getElementById('cat_fact');
    const cat_pic = document.getElementById('cat_pic');
    const caption = document.getElementById('caption_box');

    fetch(API_BASE + '/' + id)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            cardData = {};
            cardData['catCardId'] = data.catCardId;
            cardData['catFact'] = data.catFact;
            cardData['imgUrl'] = data.imgUrl;
            cardData['caption'] = data.caption;
            caption.value = data.caption;
            caption.disabled = false;
            caption.style.textAlign = 'left';
            cat_fact.innerText = data.catFact;
            cat_pic.setAttribute('src', data.imgUrl);
            caption.focus();
        });
}

function deleteHandler(event, id) {
    fetch(API_BASE + '/' + id, {
        method: 'DELETE',
    })
        .then((response) => {
            return response.text();
        })
        .then((data) => {
            console.log(data);
            alert('Cat Card deleted!');
            refreshCollection();
        })
        .catch((err) => {
            console.error(err);
            alert('Could not delete Cat Card!');
        });
}

function addId(container, id) {
    const hidden = document.createElement('input');
    hidden.type = 'hidden';
    hidden.value = id;
    container.appendChild(hidden);
}

function addFact(container, fact) {
    const h5 = document.createElement('h5');
    h5.innerText = fact;
    h5.classList.add('collection-fact');
    container.appendChild(h5);
}

function addPic(container, img_url) {
    const img = document.createElement('img');
    img.src = img_url;
    img.classList.add('collection-pic');
    container.appendChild(img);
}

function addCaption(container, caption) {
    const d = document.createElement('div');
    d.innerText = caption;
    container.appendChild(d);
}

function addIcons(container, id) {
    const outerDiv = document.createElement('div');
    outerDiv.style.display = 'flex';
    outerDiv.style.justifyContent = 'space-around';

    const leftDiv = document.createElement('div');
    leftDiv.innerHTML = '&#x270D;';
    leftDiv.classList.add('edit_buttons');
    leftDiv.style.cursor = 'pointer';
    leftDiv.addEventListener('click', event => { editHandler(event, id)});

    const rightDiv = document.createElement('div');
    rightDiv.innerHTML = '❌';
    rightDiv.classList.add('delete_buttons');
    rightDiv.style.cursor = 'pointer';
    rightDiv.addEventListener('click', event => { deleteHandler(event, id)});

    outerDiv.appendChild(leftDiv);
    outerDiv.appendChild(rightDiv);

    container.appendChild(outerDiv);
}