# Projet-TER-Master-Miage-
projet pour la matière TER


Mis en place de L'application:

1)Telecharger le fichier.zip
2)extraire les fichiers du .zip
3)Dans un terminal se placer \Projet-TER-Master-Miage-\code
4)Exécuter la commande psql -h tp-postgres -U monlogin_a (remplacer par votre login) puis mdp = monlogin_a
5)Exécuter à la suite les commandes \i createbase.sql et \i insertionbase.sql
6)Ouvrir Eclipse avec comme workspace \Projet-TER-Master-Miage-\code
7)Creer un nouveau Projet Java qui s'appelle "Projet" puis finir la création
8)Creer un nouveau Server Tomcat et le lier à Projet
9)Si problème de .jar clique droit sur projet puis configure build bath et redonner les accès des .jar 
qui sont dans le fichier \Projet-TER-Master-Miage-\code\Projet\WebContent\WEB-INF\lib\...
10)Ensuite, ouvrir la classe Database.java et à la ligne 28 modifier les deux cbouch3_a par vos login
11)Lancer ensuite la classe HomeServlet.java à l'aide du server et Amusez-vous avec le site.