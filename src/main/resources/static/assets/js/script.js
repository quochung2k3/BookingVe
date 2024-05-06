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

OptionMenuInput('from_input','.input-wrapper-from');
OptionMenuInput('to_input','.input-wrapper-to');
OptionMenuInput('date_input','.input-wrapper-date');
optionClick("from");
optionClick("to")

