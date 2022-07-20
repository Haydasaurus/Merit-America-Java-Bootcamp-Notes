document.addEventListener('DOMContentLoaded', () => {
  if (typeof multiplyTogether !== 'undefined') {
    document.getElementById('multiply-together').innerText = multiplyTogether(66, 87);
    document.getElementById('multiply-nothing').innerText = multiplyTogether();
  }
  if (typeof multiplyNoUndefined !== 'undefined') {
    document.getElementById('multiply-defaults').innerText = multiplyNoUndefined();
  }

  let givenArray = [3, 7, 12, 16, 15, 21, 26];
  document.querySelectorAll('span.given-array').forEach((element) => {
    element.innerText = JSON.stringify(givenArray);
  });
  if (typeof sumAllNumbers !== 'undefined') {
    document.getElementById('sum-all-numbers').innerText = sumAllNumbers(givenArray);
  }
  if (typeof allDivisibleByThree !== 'undefined') {
    document.getElementById('divisible-by-three').innerText = JSON.stringify(
      allDivisibleByThree(givenArray)
    );
  }
});
