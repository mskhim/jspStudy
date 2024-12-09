const leftBotton = document.querySelector("#navgateleft");
const rightBotton = document.querySelector("#navgateright");
const imgArray = document.querySelectorAll(`header>a>img`);
const navBotton = document.querySelectorAll(`#indicator>a`);
let list = [1, 0, 0, 0];

// 배치해주는 함수
function set() {
  for (let i = 0; i < imgArray.length; i++) {
    imgArray[i].style.zIndex = list[i];
  }
  for (let i = 0; i < imgArray.length; i++) {
    navBotton[i].classList.remove("active");
  }
  navBotton[list.indexOf(1)].classList.add("active");
}
set();
leftBotton.addEventListener("click", () => {
  list.push(list.shift());
  set();
});
function moveRight() {
  list.unshift(list.pop());
  set();
}
rightBotton.addEventListener("click", moveRight);

for (let i = 0; i < 4; i++) {
  navBotton[i].addEventListener("click", () => {
    list = [0, 0, 0, 0];
    list[i] = 1;
    set();
  });
}
let all = document.querySelector("header");
function startTimer() {
  timerID = setInterval(moveRight, 3000);
}
startTimer();
all.addEventListener("mouseenter", () => {
  clearInterval(timerID);
});
all.addEventListener("mouseleave", () => {
  startTimer();
});
