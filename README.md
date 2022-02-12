## Bien venidos al api quasar
Nombre clave patitoDeHule
** instalacion
revisar instalacion de java (usar java version)
de no existir un java instalado intalarlo
instalar maven
clonar este repositorio https://github.com/tathomartinez/quasar.git

# endPoints
* http://localhost:5000/topsecret 
- methodo : POST
- funcionalidad : Recibe un array con los fragmento , distancia y emisor del mensaje obtenido por los satelites
- input : lista de fragmento , distancia y emisor del mensaje obtenido por los satelites
- ![image](https://user-images.githubusercontent.com/68938147/153693115-7568fd42-64a5-4974-a64d-992fc3893f3d.png)
- output : salida de la posicion y mensaje
- ![image](https://user-images.githubusercontent.com/68938147/153693143-cfeb3271-b1e9-4c15-add5-df2ecdce32e8.png)
        
* http://localhost:5000/reset
- methodo : GET
- funcionalidad : limpiar posibles mensajes en cache o reiniciar los escuchas para recibir los nuevos mensajes
- input : n/a
- output : n/a
  
* http://localhost:5000/topsecret_split/
- methodo : GET
- funcionalidad : decifrar los mensajes que ya tenemos en nuestra sesion
- input : n/a
- output : 
- si no hay suficientes datos arrojara el sigueinte error
- ![image](https://user-images.githubusercontent.com/68938147/153693555-f19b72bc-4f96-4119-8a89-433256e0e55b.png)
- si encuetra datos
- ![image](https://user-images.githubusercontent.com/68938147/153693585-31dde18b-b341-4a82-b30b-e344450f13b9.png)

* http://localhost:5000/topsecret_split/{1}
- methodo : POST
- funcionalidad : persistir mensaje y distancia de los satelites activos
- input : estructura con distancia y mensaje
- ![image](https://user-images.githubusercontent.com/68938147/153693649-150269fa-cd3a-4ac9-a17a-8a43ee7eb9a4.png)
- output : salida de mensaje exitoso de 
- si no hay suficientes datos arrojara el sigueinte error
- ![image](https://user-images.githubusercontent.com/68938147/153693555-f19b72bc-4f96-4119-8a89-433256e0e55b.png)
- si encuetra datos
- ![image](https://user-images.githubusercontent.com/68938147/153693585-31dde18b-b341-4a82-b30b-e344450f13b9.png)
