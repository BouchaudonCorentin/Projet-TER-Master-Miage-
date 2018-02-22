<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
    <head>
		<meta charset="utf-8">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<title>Netflox</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- favicon
		============================================ -->
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/affiche_video.css">

    </head>
	<body class="bg">
    <h1 class="page-header"> Mon voisin Totoro </h1>
		<!-- video-section-start -->
		<div class="displaytable">
			<div class="displaytablecell">
				<div class="video-area">
					<div id="wrapper">
						<div class="videoContainer">
							<video id="myVideo" controls preload="auto"  >
								<source src="mp4" type="video/mp4" />
							</video>
							<div class="caption">Video Caption</div>
							<div class="control">
								<div class="btmControl">
									<div class="btnPlay btn" title="Play/Pause video"><span class="icon-play"></span></div>
									<div class="progress-line">
										<div class="progres">
											<span class="bufferBar"></span>
											<span class="timeBar"></span>
										</div>
									</div>
									<div class="sound sound2 btn" title="Mute/Unmute sound"><span class="icon-sound"></span></div>
									<div class="btnFS btn" title="Switch to full screen"><span class="icon-fullscreen"></span></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
    		<!-- video-section-end -->
     <div class="col-md-2" id="detailMovie" >
          <p id="name"> Titre : Mon voisin totoro</p>
          <p id="realisateur">Realisateurs : studio Ghibli</p>
          <p>  Resume :</p>
          <p id="resume">

              c est le meilleur film du monde bla bla bla bla
              c est le meilleur film du monde bla bla bla bla
              c est le meilleur film du monde bla bla bla bla
              c est le meilleur film du monde bla bla bla bla
              c est le meilleur film du monde bla bla bla bla
          </p>
      </div>

        <script src="resources/js/affiche_video.js"></script>
    </body>
</html>
