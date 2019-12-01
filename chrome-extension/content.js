let images = document.images;
for(let i = 0; i < images.length; i++){
  chrome.runtime.sendMessage({msg: 'image', index: i}, function({data, index}){
    // console.log(data.url);
    images[index].src = "";
    images[index].alt = data.description;
    // alert(data.description);
    alert("meme" + i);
    chrome.runtime.sendMessage({toSay: "meme" + i + data.description});

  });
}