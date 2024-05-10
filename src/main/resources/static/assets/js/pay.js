var timeoutHeader = document.getElementById('timeoutHeader');
var timeoutCounter = document.getElementById('timeoutCounter');
var remainingTime = 10 * 60; // 10 phút * 60 giây/phút

function updateTimeoutCounter() {
    var minutes = Math.floor(remainingTime / 60);
    var seconds = remainingTime % 60;
    timeoutCounter.textContent = minutes.toString().padStart(2, '0') + ":" + seconds.toString().padStart(2, '0');
}

// Hiển thị header timeout sau 10 phút
setTimeout(function() {
    timeoutHeader.style.display = 'block';
}, 10 * 60 * 1000); // 10 phút * 60 giây/phút * 1000 miligiây/giây

// Cập nhật thời gian còn lại sau mỗi giây
var countdownInterval = setInterval(function() {
    remainingTime--;
    updateTimeoutCounter();
    if (remainingTime <= 0) {
        clearInterval(countdownInterval);
        // Thực hiện hành động timeout ở đây, ví dụ: chuyển hướng đến trang khác
        window.location.href = 'timeout.html'; // Thay đổi 'timeout.html' thành URL bạn muốn chuyển hướng
    }
}, 1000); // 1000 miligiây = 1 giây

document.addEventListener("DOMContentLoaded", function() {
    var antRadioWrappers = document.querySelectorAll('.ant-radio-wrapper');
    antRadioWrappers.forEach(function(antRadioWrapper) {
        antRadioWrapper.addEventListener('click', function() {
            antRadioWrappers.forEach(function(otherRadioWrapper) {
                otherRadioWrapper.classList.remove('checked');
            });

            antRadioWrapper.classList.add('checked');

            var radioInputs = document.querySelectorAll('.ant-radio-input') ;
            radioInputs.forEach(function(input) {
                input.classList.remove('checked');
            });

            var currentInput = antRadioWrapper.querySelector('.ant-radio-input');
            currentInput.classList.add('checked');
        });
    });

    document.querySelector(".btn-back-QR").addEventListener("click", function() {
        AddHeight();
        document.querySelector(".payment-method.QR").classList.add("hidden");
        document.querySelector(".ant-drawer-mask").classList.add("hidden");
    });

    document.querySelector(".btn-back-VISA").addEventListener("click", function() {
        AddHeight();
        document.querySelector(".payment-method.VISA").classList.add("hidden");
        document.querySelector(".ant-drawer-mask").classList.add("hidden");
    });
})


function AddHeight(){
    var pageHeight = document.body.scrollHeight;
    var element = document.querySelector(".ant-drawer-mask");
    element.style.height = pageHeight + "px";
}


function payMethod(){
    var QRMethod = document.querySelector(".QR.checked");
    var VISAMethod = document.querySelector(".VISA.checked")
    if(VISAMethod){
        AddHeight();
        document.querySelector(".payment-method.VISA").classList.remove("hidden");
        document.querySelector(".ant-drawer-mask").classList.remove("hidden");
    }
    else
    if(QRMethod){
        AddHeight();
        document.querySelector(".payment-method.QR").classList.remove("hidden");
        document.querySelector(".ant-drawer-mask").classList.remove("hidden");
    }
    else
        alert("Vui lòng chọn phương thức thanh toán ")
}