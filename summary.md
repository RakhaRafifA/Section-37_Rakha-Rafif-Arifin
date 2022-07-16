# **(37) Docker Container with Microservices**

## **Resume**
Pada section 37 ini kita mempelajari tentang docker dan kegunaannya.
Docker, Docker adalah layanan yang menyediakan kemampuan untuk mengemas dan menjalankan sebuah aplikasi dalam sebuah lingkungan terisolasi yang disebut dengan container. Dengan adanya isolasi dan keamanan yang memadai memungkinkan kamu untuk menjalankan banyak container di waktu yang bersamaan pada host tertentu. Keuntungan menggunakan docker yaitu :
1. Portability
2. Performance
3. Agility
4. Isolation
5. Scalability

Beberapa atribut docker yang perlu diperhatikan :

1. Docker Dockerfile, Dockerfile adalah sebuah file yang berisikan command pada docker yang dapat digunakan oleh user untuk membuat sebuah images. Dengan docker build user dapat membuat images docker secara otomatis.

2. Docker Daemon, Docker daemon adalah sebuah service yang berjalan pada sistem operasi kita Fungsinya adalah membangun, mendistribusikan, dan menjalankan container docker. Pengguna tidak dapat langsung menggunakan docker daemon, akan tetapi untuk menggunakan docker daemon maka pengguna menggunakan docker client sebagai perantara atau CLI.

3. Docker Images, Docker images adalah sebuah template yang bersifat read only. Template ini sebenarnya adalah sebuah OS atau OS yang telah diinstall berbagai aplikasi. Fungsi dari docker images sendiri adalah membuat docker container, hanya dengan satu docker image kita dapat membuat banyak docker container.

4. Docker Container, Docker container bisa dianggap sebagai sebuah folder, docker container dibuat menggunakan docker daemon. Docker container ini nantinya dapat dibuild sehingga akan menghasilkan sebuah docker image dan docker image yang dihasilkan dari docker container ini dapat kita gunakan kembali untuk membuat docker container yang baru.

5. Docker Registry, Docker registry adalah kumpulan docker image yang bersifat private maupun public yang dapat anda akses di docker hub. Kita dapat push atau pull image kita sendiri di sini.

6. Docker/Container Orchestration, adalah suatu kegiatan mengatur siklus hidup dari container, terutama dalam environment yang besar dan dinamis. Developer dapat menggunakan container orchestration untuk mengontrol dan mengautomasi banyak pekerjaan

7. Docker Network, yaitu sebuah service dimana kita dapat menghubungkan docker container dan docker service atau mengkoneksikan dengan non docker workloads

8. Docker Volume, adalah mekanisme untuk menyimpan data yang dihasilkan dan digunakan oleh container Docker. Jika mount dan bind bergantung pada struktur direktori dan OS dari host, maka volume sepenuhnya dikelola oleh Docker.

9. Docker Log, digunakan untuk memonitoring docker yang sedang berjalan apakah ada error atau tidak dan memberikan kita informasi tentang docker tersebut

10. Docker Swarm, Mode ini memungkinkan pengguna untuk me-deploy container pada multiple hosts atau node, menggunakan overlay network. Swarm mode merupakan bagian dari command line interface Docker yang memudahkan pengguna untuk memanage komponen container apabila sudah familiar dengan command — command yang ada di Docker


## **Praktikum**
Build your own docker images based from spring boot project using docker

Untuk source codenya dapat dilihat di [Praktikum section 37](https://github.com/RakhaRafifA/Java-Spring-Boot_Rakha-Rafif-Arifin/tree/main/37_Docker%20Container%20with%20Microservices/praktikum/section37)

1. Build jar menggunakan settingan docker pada Dockerfile dan dengan syntax "docker build -t rakha-section37"
![screenshot1](https://github.com/RakhaRafifA/Java-Spring-Boot_Rakha-Rafif-Arifin/blob/da4a9a65f25f88f15d1d6a8326c8249ba759afad/37_Docker%20Container%20with%20Microservices/screenshot/Screenshot1%20-%20Jar%20Build.PNG)

2. Menjalankan springboot dengan docker dengan syntax "docker run --rm -p 8080:8080 rakha-section37"
![screenshot2](https://github.com/RakhaRafifA/Java-Spring-Boot_Rakha-Rafif-Arifin/blob/da4a9a65f25f88f15d1d6a8326c8249ba759afad/37_Docker%20Container%20with%20Microservices/screenshot/Screenshot2%20-%20Run.PNG)

3. Cek pada docker app apakah images yang kita jalankan berjalan
![screenshot3](https://github.com/RakhaRafifA/Java-Spring-Boot_Rakha-Rafif-Arifin/blob/da4a9a65f25f88f15d1d6a8326c8249ba759afad/37_Docker%20Container%20with%20Microservices/screenshot/Screenshot3%20-%20Docker%20App.PNG)

4. Cek endpoint pada browser apakah project spring-boot berjalan atau tidak, disini saya menggunakan swagger
![screenshot4](https://github.com/RakhaRafifA/Java-Spring-Boot_Rakha-Rafif-Arifin/blob/da4a9a65f25f88f15d1d6a8326c8249ba759afad/37_Docker%20Container%20with%20Microservices/screenshot/Screenshot3%20-%20Test%20Localhost.PNG)