# build environment
FROM node:14-alpine AS build_stage

WORKDIR /usr/src/app

#RUN apk update && apk add --update git && apk add --update openssh

COPY package.json package-lock.json ./

RUN npm install

#RUN npm rebuild node-sass

COPY . .

RUN npm run build-prod

# production environment
FROM nginx:stable-alpine

COPY --from=build_stage /usr/src/app/dist/ /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
