# Mini-Social-Network

Server:Java, Spring REST, Spring Web Security, Hibernate, MySql Database

Client: JavaFx

Descriere:

Un sistem client-server care simuleaza un site de socializare astfel:

Serverul are o lista de utilizatori, fiecare utilizator fiind identificat prin username si password. (a/a, b/b, c/c)
Fiecare utilizator are o lista de prieteni (a prieten cu c, iar b prieten cu c).
La lansarea app client, utilizatorul este autentificat.
Dupa autentificare, utilizatorul vede toate postarile inregistrate de el si de prietenii lui.
Utilizatorul poate adauga o postare.
Automat dupa adaugarea unei postari, toate app client ale prietenilor autorului postarii vor fi actualizate.
Cerinte nefunctionale

Entitatile sistemului vor fi persistate in fisiere sau baze de date de catre server.
App client tb sa aiba GUI desktop sau web.
Comunicarea intre client-server via http sau tcp.
Aplicatia client nu blocheaza firul principal cu operatii IO.
Pe durata executiei operatiilor IO aplicatia client prezinta un progress indicator.
Operatiile efectuate de client pot fi anulate (cancellable) de utilizator.
