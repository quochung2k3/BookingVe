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
    document.querySelector(".btn-pick-up").addEventListener("click", function() {
        AddHeight();
        document.querySelector(".pick-up-point").classList.remove("hidden");
        document.querySelector(".ant-drawer-mask").classList.remove("hidden");
        document.querySelector(".drop-off-point").classList.add("hidden");
    });
    document.querySelector(".btn-drop-off").addEventListener("click", function() {
        AddHeight();
        document.querySelector(".drop-off-point").classList.remove("hidden");
        document.querySelector(".pick-up-point").classList.add("hidden");
        document.querySelector(".ant-drawer-mask").classList.remove("hidden");
    });

    document.querySelector(".back-btn-pick").addEventListener("click", function() {
        AddHeight();
        document.querySelector(".pick-up-point").classList.add("hidden");
        document.querySelector(".ant-drawer-mask").classList.add("hidden");
    });

    document.querySelector(".back-btn-drop").addEventListener("click", function() {
        AddHeight();
        document.querySelector(".drop-off-point").classList.add("hidden");
        document.querySelector(".ant-drawer-mask").classList.add("hidden");
    });
});


function change(a){
    document.querySelector(".ant-drawer-mask").classList.add("hidden");
    document.querySelector("."+a+"-point").classList.add("hidden");
    var baseHeadlineElement = document.querySelector('.'+a+' .base-headline');
    var baseSmallElement = document.querySelector('.'+a+' .section-area .base-small');
    var pickUpAndDropIdChange = document.querySelector('.'+a+' .section-area .pickUpAndDropIdChange');
    var baseChange = document.querySelector('.ant-radio-wrapper.checked')
    console.log(baseChange);
    console.log(baseHeadlineElement);
    console.log(baseSmallElement);
    // Thay đổi nội dung của phần tử
    // pickUpAndDropIdChange
    baseSmallElement.textContent = baseChange.querySelector('.address').textContent;
    pickUpAndDropIdChange.value = baseChange.querySelector('.pickUpAndDropIdChange').value;
}

function AddHeight(){
    var pageHeight = document.body.scrollHeight;
    var element = document.querySelector(".ant-drawer-mask");
    element.style.height = pageHeight + "px";
}

var listSeat = [];
var listSeatId = [];
function changeRectColor(classList, money) {
    var newClass = classList[classList.length - 1];
    console.log(newClass.toString());
    var parts = newClass.split('_');
    var elementWithNewClass = document.querySelector('.' + newClass);
    var rects = elementWithNewClass.querySelectorAll('rect');

    rects.forEach(function(rect) {
        var currentFill = rect.getAttribute('fill');
        var currentStroke = rect.getAttribute('stroke');

        if (currentFill === '#8BE5B0' && currentStroke === '#27AE60') {
            rect.setAttribute('fill', '#FFF');
            rect.setAttribute('stroke', '#B8B8B8');
        }
        else {
            rect.setAttribute('fill', '#8BE5B0');
            rect.setAttribute('stroke', '#27AE60');
        }
    });
    var index = listSeat.indexOf(parts[0]);
    if(index === -1) {
        listSeat.push(parts[0]);
        listSeatId.push(parts[1]);
    }
    else {
        listSeat.splice(index, 1);
        listSeatId.splice(index, 1);
    }
    var totalPriceText = document.querySelector('.total-price-text').textContent;
    var total = totalPriceText.replace(/\D/g, '');
    var totalText = listSeat.length * parseInt(total);
    if(listSeat.length > 0) {
        document.getElementById('list-seat-name').innerHTML = "Số ghế: {" + listSeat.toString() + "}";
    }
    else {
        document.getElementById('list-seat-name').innerHTML = "";
    }
    document.getElementById('list-seat-name-value').value = "{" + listSeat.toString() + "}";
    document.getElementById('list-seat-id-value').value = "{" + listSeatId.toString() + "}";
    document.getElementById('total').innerHTML = totalText + ' VNĐ';
    document.getElementById('totalCost').value = totalText + ' VNĐ';
}

function validateForm() {
    var inputField = document.getElementById("list-seat-name");
    if (inputField.textContent.trim() === "") {
        alert("Bạn phải điền vào trường này trước khi tiếp tục!");
        return false;
    }
    return true;
}