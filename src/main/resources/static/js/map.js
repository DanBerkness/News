/**
 * @license
 * Copyright 2019 Google LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
// Initialize and add the map
function initMap() {
  // The location of Uluru
  const minneapolis = {lat: 44.977489, lng: -93.264374};
  // The map, centered at Uluru
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 4,
    center: minneapolis,
  });
  // The marker, positioned at Uluru
  const marker = new google.maps.Marker({
    position: minneapolis,
    map: map,
  });
}

window.initMap = initMap;