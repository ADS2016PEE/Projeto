
setwd("C:/pee/");

analise <- read.table("analise.csv", ";", header = T);

#media Simples
mean(analise$MySQL);
mean(analise$PostGreSQL);
mean(analise$Neo4J);
mean(analise$SQLServer);

#media Harmonica
1 / mean(1/analise$MySQL);
1 / mean(1/analise$PostGreSQL);
1 / mean(1/analise$Neo4J);
1 / mean(1/analise$SQLServer);

#media Geometrica
prod(analise$MySQL)**(1/length(analise$MySQL));
prod(analise$PostGreSQL)**(1/length(analise$PostGreSQL));
prod(analise$Neo4J)**(1/length(analise$Neo4J));
prod(analise$SQLServer)**(1/length(analise$SQLServer));


#---------------------------------

#Amplitude

max(analise$MySQL) - min(analise$MySQL);
max(analise$PostGreSQL) - min(analise$PostGreSQL);
max(analise$Neo4J) - min(analise$Neo4J);
max(analise$SQLServer) - min(analise$SQLServer);

#variancia
var(analise$MySQL);
var(analise$PostGreSQL);
var(analise$Neo4J);
var(analise$SQLServer);

#desvio padrão
sd(analise$MySQL);
sd(analise$PostGreSQL);
sd(analise$Neo4J);
sd(analise$SQLServer);

#coeficiente de variação
sd(analise$MySQL)/mean(analise$MySQL) * 100;
sd(analise$PostGreSQL)/mean(analise$PostGreSQL) * 100;
sd(analise$Neo4J)/mean(analise$Neo4J) * 100;
sd(analise$SQLServer)/mean(analise$SQLServer) * 100;

#mediano de desvio absoluto
median(abs(analise$MySQL - median(analise$MySQL)));
median(abs(analise$PostGreSQL - median(analise$PostGreSQL)));
median(abs(analise$Neo4J - median(analise$Neo4J)));
median(abs(analise$SQLServer - median(analise$SQLServer)));

#minimo
min(analise$MySQL);
min(analise$PostGreSQL);
min(analise$Neo4j);
min(analise$SQLServer);


#maximo
max(analise$MySQL);
max(analise$PostGreSQL);
max(analise$Neo4j);
max(analise$SQLServer);

#mediana
median(analise$MySQL);
median(analise$PostGreSQL);
median(analise$Neo4J);
median(analise$SQLServer);

#media harmonica das medias obtidas dos sgbds na mesma ordem ordem
#vetor <- c(media simples, media harmonica, media geometrica)
a <- c (157.3667, 156.4079, 156.8732);
b <- c (5.833333, 5.647692, 5.727024)
c <- c (164.7333, 161.6794, 163.1629);
d <- c (3.3, 3.231598, 3.263387);

1 / mean(1/a);
1 / mean(1/b);
1 / mean(1/c);
1 / mean(1/d);

end




