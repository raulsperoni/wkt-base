Proyecto base Wicket.

1- Dejar que Maven haga la magia.

2- Correr maven deploy

3- Configurar un JBOSS en Run Configurations

4- Copiar el driver postgres de .m2/org/postgres/ a jboss/deployments/standalone

5- Run Configurations: Before Lauch: Make, Maven goal: orgnk-deploy

6- En Deployments agregar el artefacto ear/target/orgnk-ear.ear

7- Crear una BD: orgnk. postgres/postgres

