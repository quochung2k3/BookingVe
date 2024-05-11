document.addEventListener("DOMContentLoaded", function() {
    OptionMenuInput('from_input','.input-wrapper-from');
    OptionMenuInput('to_input','.input-wrapper-to');
    optionClick("from");
    optionClick("to");
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

            //Sắp xếp và load lại danh sách tại đây


        });
    });

    //Load lại trang khi nhấn vào lọc
    document.querySelector(".btn-clear").addEventListener('click',function(){
        //Tìm kiếm và thêm url cho web để load bộ lọc


    })
})

function OptionMenuInput(a,b){
    const inputField = document.getElementById(a);
    const inputWrapper = document.querySelector(b);

    inputField.addEventListener('focus', function() {
        inputWrapper.classList.add('active');
    });

    inputField.addEventListener('blur', function() {
        inputWrapper.classList.remove('active');
    });
}

function SwapClick(){
    var tam = document.getElementById("from_input").value;
    document.getElementById("from_input").value = document.getElementById("to_input").value;
    document.getElementById("to_input").value = tam;
}

function optionClick(a){
    var options = document.querySelectorAll("#"+a+"_menu_list li");
    options.forEach(function(item){
        item.addEventListener("click", function() {
            document.getElementById(a+"_input").value = item.innerText;
        });
    })
}