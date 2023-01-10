#!/bin/bash

cd "$(dirname "$0")/target" || exit
java -XX:+UseG1GC \
    -Xms512m \
    -Xmx1024m \
    -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
    -jar Spotify_5-*-microbundle.jar \
    --systemproperties C:/Users/CTW00555-admin/IdeaProjects/Spotify_5.0/src/main/deployment/common/config-maps/config/app.properties \
    --nocluster \
    --port 9090
