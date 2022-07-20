document.addEventListener('DOMContentLoaded', () => {
  if (typeof turnOn !== 'undefined' && turnOn()) {
    document.querySelector('div.container').classList.remove('d-none');

    if (typeof returnsName !== 'undefined') {
      document.getElementById('name').innerText = returnsName();
    }

    if (typeof returnGivenParameter !== 'undefined') {
      document.getElementById('given-thing').innerText = returnGivenParameter('the given thing');
    }
    if (typeof takeOptionalParameter !== 'undefined') {
      document.getElementById('default-thing').innerText = takeOptionalParameter();
    }

    let givenArray = [1, 3, 4, 12, 6, 75, 8, 15, 56];

    document.getElementById('number-given-array').innerText = JSON.stringify(givenArray);
    document.getElementById('single-digit-array').innerText = JSON.stringify(
      filterArrayToOnlySingleDigitNumbers(givenArray)
    );
    document.getElementById('doubled-array').innerText = JSON.stringify(
      mapArrayToDoubleAllNumbers(givenArray)
    );
    document.getElementById('array-product').innerText = JSON.stringify(
      reduceArrayToFindProduct(givenArray)
    );

    givenArray = ['Jackson', 'Johnson', 'Miller', 'Erickson', 'Fredrick'];

    document.getElementById('name-given-array').innerText = JSON.stringify(givenArray);
    document.getElementById('name-son-array').innerText = JSON.stringify(
      filterStringArrayForSon(givenArray)
    );
    document.getElementById('capitalized-array').innerText = JSON.stringify(
      makeNamesAllCaps(givenArray)
    );
  }
});
