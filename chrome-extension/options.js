// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.


let page = document.getElementById('buttonDiv');
const kButtonColors = ['#3aa757', '#e8453c', '#f9bb2d', '#4688f1'];
function constructOptions(kButtonColors) {
  for (let item of kButtonColors) {
    let button = document.createElement('button');
    button.style.backgroundColor = item;
    let num = kButtonColors.indexOf(item);
    button.textContent = num;
    button.addEventListener('click', function() {
      localStorage.setItem("speed", num);
      alert(localStorage.getItem("speed"));
      // chrome.storage.local.set({"speed": num}, function() {
      //   chrome.storage.local.get("speed"), function(m) {
      //     alert(m);
      //   }
      // });
    });
    page.appendChild(button);
  }
}
constructOptions(kButtonColors);
