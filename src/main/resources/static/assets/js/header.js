document.addEventListener("DOMContentLoaded", function() {


    document.querySelector(".picture-account").addEventListener("click", function() {
        var hiddenOption = document.querySelector(".option-account.hidden")
        if(hiddenOption){
            document.querySelector(".option-account").classList.remove("hidden");
        }
        else
            document.querySelector(".option-account").classList.add("hidden");
    });

})
