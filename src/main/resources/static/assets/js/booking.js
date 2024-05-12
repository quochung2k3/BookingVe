var busListSearch = document.querySelectorAll(".wrap-ticket-container");
function Filter(){

    var listFilter = []
    var minTime = new Date("1970-01-01T"+document.getElementById("min_time").value);
    var maxTime = new Date("1970-01-01T"+document.getElementById("max_time").value);
    var minPrice = parseInt(document.getElementById("min_price").value);
    var maxPrice = parseInt(document.getElementById("max_price").value);
    var listCheckbox = document.querySelectorAll(".ant-checkbox");
    var listName = []
    listCheckbox.forEach(function (checkbox){
        if (checkbox.querySelector(".ant-checkbox-input").checked){
            listName.push(checkbox);
        }
    })
    console.log(listName);
    console.log(minTime);
    console.log(maxPrice);
    console.log(maxTime);
    console.log(minPrice);
    busListSearch.forEach(function (bus){
        var date = new Date("1970-01-01T"+bus.querySelector(".hour").textContent);
        var busName = bus.querySelector(".bus-name").textContent;
        var Price = parseInt(bus.querySelector(".fare").textContent.replace(/\D/g, ''));
        listName.forEach(function (name){
            if(name.querySelector(".name").innerText === busName){
                if(Price<=maxPrice && Price>=minPrice){
                    if(date<=maxTime && date>=minTime){
                        listFilter.push(bus);
                    }
                }
            }
        })
    })
    console.log(listFilter);

    var newContent = document.querySelector(".infinity-scroll");
    newContent.innerHTML = "";
    listFilter.forEach(function(bus){
        newContent.appendChild(bus);
    })
    console.log(newContent);

}


function sortDescTime(){
    var busList = document.querySelectorAll(".wrap-ticket-container");
    console.log(busList);
    var ListDate = []
    busList.forEach(function (bus){
        var date = new Date("1970-01-01T"+bus.querySelector(".hour").textContent);
        ListDate.push({bus,date});
    });

    ListDate.sort(function(a,b){
        return b.date - a.date;
    })
    console.log(ListDate);

    var newContent = document.querySelector(".infinity-scroll");
    newContent.innerHTML = "";
    ListDate.forEach(function(bus){
        newContent.appendChild(bus.bus);
    })
    console.log(newContent);
}
function sortAscTime(){
    var busList = document.querySelectorAll(".wrap-ticket-container");
    console.log(busList);
    var ListDate = []
    busList.forEach(function (bus){
        var date = new Date("1970-01-01T"+bus.querySelector(".hour").textContent);
        ListDate.push({bus,date});
    });

    ListDate.sort(function(a,b){
        return a.date - b.date;
    })
    console.log(ListDate);

    var newContent = document.querySelector(".infinity-scroll");
    newContent.innerHTML = "";
    ListDate.forEach(function(bus){
        newContent.appendChild(bus.bus);
    })
    console.log(newContent);
}
function sortdf(){
    var busList = document.querySelectorAll(".wrap-ticket-container");
    var newContent = document.querySelector(".infinity-scroll");
    newContent.innerHTML = "";
    busList.forEach(function(bus){
        newContent.appendChild(bus);
    })
    console.log(newContent)
}
function sortAscPrice(){
    var busList = document.querySelectorAll(".wrap-ticket-container");
    var ListPrice =[];
    busList.forEach(function (bus){
        var Price = parseInt(bus.querySelector(".fare").textContent.replace(/\D/g, ''));
        console.log(Price);
        ListPrice.push({bus,Price});
    });
    ListPrice.sort(function(a, b) {
        return a.Price - b.Price;

    });
    console.log(ListPrice);


    var newContent = document.querySelector(".infinity-scroll");
    newContent.innerHTML = "";
    ListPrice.forEach(function(bus){
        newContent.appendChild(bus.bus);
    })
    console.log(newContent)
}

function sortDescPrice(){
    var busList = document.querySelectorAll(".wrap-ticket-container");
    var ListPrice =[];
    busList.forEach(function (bus){
        var Price = parseInt(bus.querySelector(".fare").textContent.replace(/\D/g, ''));
        console.log(Price);
        ListPrice.push({bus,Price});
    });
    ListPrice.sort(function(a, b) {
        return b.Price - a.Price;

    });
    console.log(ListPrice);


    var newContent = document.querySelector(".infinity-scroll");
    newContent.innerHTML = "";
    ListPrice.forEach(function(bus){
        newContent.appendChild(bus.bus);
    })
    console.log(newContent)
}


