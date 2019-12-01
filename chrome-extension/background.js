chrome.runtime.onMessage.addListener(function(message, sender, senderResponse){
  if(message.msg === "image"){
    fetch('http://localhost:8080/?url=https://www.fosi.org/media/images/funny-game-of-thrones-memes-coverimage.width-800.jpg')
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