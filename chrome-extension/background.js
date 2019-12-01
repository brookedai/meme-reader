chrome.runtime.onMessage.addListener(function(message, sender, senderResponse){
  if(message.msg === "image"){
    fetch('http://localhost:8080/?url=' + message.url)
          .then(response => response.text())
          .then(data => {
            let dataObj = JSON.parse(data);
            senderResponse({data: dataObj, index: message.index});
          })
          .catch(error => console.log("error", error))
      return true;  
  }
});

chrome.runtime.onMessage.addListener(function(request) {
  // let prefSpeed = chrome.storage.local.get("speed") * 0.8;
  // alert(prefSpeed);
  chrome.tts.speak(request.toSay, 
                  { rate: Math.max(localStorage.getItem("speed") * 0.8, 0.5), onEvent: function(event) {}}, function() {});
});