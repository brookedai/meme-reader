chrome.runtime.onMessage.addListener(function(message, sender, senderResponse){
  if(message.msg === "image"){
    fetch('https://thawing-earth-15388.herokuapp.com/?desc=test')
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
  chrome.tts.speak(request.toSay, 
                  { rate: 0.6, onEvent: function(event) {}}, function() {});
});