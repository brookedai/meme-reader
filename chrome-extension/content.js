let images = document.images;
for(let i = 0; i < images.length; i++){
  chrome.runtime.sendMessage({msg: 'image', index: i, url: images[i].src}, function({data, index}){
    // console.log(data.url);
    images[index].width = images[index].width * 1.5;
    images[index].height = images[index].height * 1.5;
    images[index].style.border = "2px solid red";
    // images[index].src = "";
    if (!(typeof data.desc  === 'undefined') && !(typeof data.desc === 'null')) {
      images[index].alt = data.desc;
      // alert(data.description);
      alert("meme" + i);
      chrome.runtime.sendMessage({toSay: "meme" + i + data.desc});
    }

  });
}