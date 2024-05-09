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
    var baseChange = document.querySelector('.ant-radio-wrapper.checked')
    console.log(baseChange);
    console.log(baseHeadlineElement);
    console.log(baseSmallElement);
    // Thay đổi nội dung của phần tử
    baseHeadlineElement.textContent = baseChange.querySelector('.time').textContent;
    baseSmallElement.textContent = baseChange.querySelector('.address').textContent;
}

function AddHeight(){
    var pageHeight = document.body.scrollHeight;
    var element = document.querySelector(".ant-drawer-mask");
    element.style.height = pageHeight + "px";
}