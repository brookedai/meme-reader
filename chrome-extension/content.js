let images = document.images;
for(let i = 0; i < images.length; i++){
  chrome.runtime.sendMessage({msg: 'image', index: i}, function({data, index}){
    // console.log(data.url);
    images[index].src = "";
    images[index].title = data.description;
    alert(data.description);
    chrome.runtime.sendMessage({toSay: data.description}, function() {});

  });
}