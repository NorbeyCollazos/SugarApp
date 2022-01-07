<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        html {
            box-sizing: border-box;
            font-size: 62.5%;
          }

          *,
          *::after,
          *::before {
            box-sizing: inherit;
          }

          body {
            margin: 0;
            padding: 0;
            line-height: 1.6;
            font-family:Arial, Helvetica, sans-serif;
          }

          h1{
            text-align: center;
        }

        p{
            text-align: justify;
            font-size: 14px;
        }

          /*Galeria de Imagenes*/

          #galeria {

            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
            grid-template-columns: repeat(4, 1fr);
            grid-gap: 2px;
            max-width: 100%;
            min-width: 100%px;
            height: 300px;
            padding: 0 10px;


          }

          #galeria img {
            width: 100%;
            height: auto;
            border-radius: 5px;
            cursor: pointer;
          }

          #img-activa {
            width: 100%;
            height: 100vh;
          }

          /*Contenedor Principal del Lightbox*/

          #contenedor-principal {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: 10;
            background-color: rgba(0, 0, 0, 0.55);
            display: none;
            justify-content: center;
            align-items: center;
          }

          /*Contenedor interno del Lightbox*/

          #contenedor-interno {
            border: 2px #f3f3f3 solid;
            padding: 2px;
            background: #3f3f3f;
            max-width: 500px;
            min-height: 400px;
            position: relative;
            display: flex;
            justify-content: center;
          }

          /*Botones*/

          button {
            cursor: pointer;
            background: transparent;
            border: none;
            color: #f3f3f3;
          }

          #btn-cierra {
            position: absolute;
            top: 0;
            right: 0;
            font-size: 3rem;
          }

          #btn-retrocede {
            position: absolute;
            top: 50%;
            left: 0;
            font-size: 3rem;
          }

          #btn-adelanta {
            position: absolute;
            top: 50%;
            right: 0;
            font-size: 3rem;
          }
    </style>
</head>
<body>
    <h1>Nombre del proyecto</h1>
    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum</p>

    <main>
        <section id="galeria">
            <img src="https://github.com/NorbeyCollazos/SugarApp/blob/master/screens/Screenshot_20220107-135341_SugarApp.jpg?raw=true" alt="galeria de imagenes">
            <img src="https://github.com/NorbeyCollazos/SugarApp/blob/master/screens/Screenshot_20220107-135354_SugarApp.jpg?raw=true" alt="galeria de imagenes">
            <img src="https://github.com/NorbeyCollazos/SugarApp/blob/master/screens/Screenshot_20220107-135402_SugarApp.jpg?raw=true" alt="galeria de imagenes">
            <img src="https://github.com/NorbeyCollazos/SugarApp/blob/master/screens/Screenshot_20220107-135414_SugarApp.jpg?raw=true" alt="galeria de imagenes">
            <img src="https://github.com/NorbeyCollazos/SugarApp/blob/master/screens/Screenshot_20220107-135427_SugarApp.jpg?raw=true" alt="galeria de imagenes">
            <img src="https://github.com/NorbeyCollazos/SugarApp/blob/master/screens/Screenshot_20220107-135438_SugarApp.jpg?raw=true" alt="galeria de imagenes">
            <img src="https://github.com/NorbeyCollazos/SugarApp/blob/master/screens/Screenshot_20220107-135505_SugarApp.jpg?raw=true" alt="galeria de imagenes">
            <img src="./img/img8.jpg" alt="galeria de imagenes">
            <img src="./img/img9.jpg" alt="galeria de imagenes">
            <img src="./img/img9.jpg" alt="galeria de imagenes">
            <img src="./img/img9.jpg" alt="galeria de imagenes">
        </section>

        <section id="contenedor-principal">
            <div id="contenedor-interno">
                <img id="img-activa" src="/img/img1.jpg" alt="galeria de imagenes">
                <button id="btn-cierra" type="button">x</button>
                <button id="btn-retrocede" type="button">&lt;</button>
                <button id="btn-adelanta" type="button">&gt;</button>
            </div>
        </section>
    </main>


    <script>
        /*Variables*/

const btnCierra = document.querySelector('#btn-cierra');
const btnAdelanta = document.querySelector('#btn-adelanta');
const btnRetrocede = document.querySelector('#btn-retrocede');
const imagenes = document.querySelectorAll('#galeria img');
const lightbox = document.querySelector('#contenedor-principal');
const imagenActiva = document.querySelector('#img-activa');
let indiceImagen = 0;

/*Abre el Lightbox*/

const abreLightbox = (event) => {
  imagenActiva.src = event.target.src;
  lightbox.style.display = 'flex';
  indiceImagen = Array.from(imagenes).indexOf(event.target);
};

imagenes.forEach((imagen) => {
  imagen.addEventListener('click', abreLightbox);
});

/*Cierra el Lightbox */

btnCierra.addEventListener('click', () => {
  lightbox.style.display = 'none';
});

/* Adelanta la imagen*/

const adelantaImagen = () => {
  if (indiceImagen === imagenes.length - 1) {
    indiceImagen = -1;
  }
  imagenActiva.src = imagenes[indiceImagen + 1].src;
  indiceImagen++;
};

btnAdelanta.addEventListener('click', adelantaImagen);

/*Retrocede la Imagen*/

const retrocederImagen = () => {
  if (indiceImagen === 0) {
    indiceImagen = imagenes.length;
  }
  imagenActiva.src = imagenes[indiceImagen - 1].src;
  indiceImagen--;
};

btnRetrocede.addEventListener('click', retrocederImagen);

    </script>
</body>
</html>
