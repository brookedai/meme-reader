let images = document.images;
for(let i = 0; i < images.length; i++){
  chrome.runtime.sendMessage({msg: 'image', index: i}, function({data, index}){
    // console.log(data.url);
    images[index].height = images[index].height * 1.5;
    images[index].width = images[index].width * 1.5;
    images[index].border = "2px solid red";
    // images[index].src = "";
    images[index].alt = data.desc;
    // alert(data.description);
    alert("meme" + i);
    chrome.runtime.sendMessage({toSay: "meme" + i + data.desc});

  });
}