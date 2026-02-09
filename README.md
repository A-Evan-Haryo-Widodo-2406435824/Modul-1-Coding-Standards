# Refleksi - 1
Setelah melakukan proses implementasi berbagai fitur, seperti Create, Read, Update, dan Delete pada program ini, saya sudah berusaha mencoba menerapkan beberapa prinsip clean code. Hal tersebut diantaranya adalah
  - Meaningful names: 
    - Pada kode di folder repository, saya telah menulis dengan jelas terkait fungsi yang merepresentasikan proses edit dan delete dengan nama "update" dan "delete". Lalu, saya juga menambahkan dua fungsi lain, yakni "findById" untuk mencari produk berdasarkan id product serta "findIndexOf" untuk mencari suatu produk dengan id tertentu terletak di index ke berapa pada tempat penyimpanannya.
- Meaningful comments:
   - Saya sudah tidak lagi melakukan proses dokumentasi komen setiap line, tetapi saya sudah mencoba membuat nama fungsi terkait relevan dengan tugasnya. Kemudian, penambahan comment yang saya lakukan terdapat pada folder repository juga yang memberi informasi bahwa saya membuat method helper pada class ProductRepository. Hal itu, saya lakukan agar tidak membuat kebingungan terhadap developer lain yang akan membaca kode saya karena method tersebut memiliki visibility private tersendiri dan tidak digunakan di luar class.

- Penerapan single responsibility principle: 
   - Kode program yang dibentuk pun telah menerapkan prinsip ini, yakni memisahkan business logic pada folder Service dan manipulasi data pada folder Repository. Salah satu contohnya adalah pada method create di file "ProductRepository.java" tidak ada pengecekan UUID terlebih dahulu sebelum add data ke dalam ArrayList, tetapi pada file "ProductServiceImpl.java" akan dicek terlebih dahulu adanya UUID atau tidak dan menjalankan proses manipulasi data dengan method yang terdapat pada repository.

Selain itu, dalam hal Secure Coding, saya sudah menerapkan proses pembuatan ID menggunakan UUID sehingga hal ini jauh lebih aman ketika terdapat proses manipulasi data yang dilakukan di client (contohnya ketika proses editing yang melibatkan route-path dengan adanya id).

Namun, saya menyadari juga bahwa program saya belum sempurna. Kelemahan program saya, yakni belum adanya input validation dan input sanitation ketika adanya proses manipulasi data melalui client. Maka dari itu, hal yang mungkin terjadi adalah ketidaksesuaian tipe data ketika pada proses client terdapat manipulasi html atau kesalahan input (implikasi dari tidak adanya input validation). Kemudian, ada juga kemungkinan XSS injection yang dapat memanipulasi web yang berjalan di production karena tidak adanya sanitasi input dari user/client. Kemudian, saya juga belum menerapkan error handling sehingga jika terdapat masalah pada program, web dapat langsung menampilkan raw errornya dan hal itu jelas melakukan exposure terhadap program saya.

Maka dari itu, program ini akan memiliki keamanan yang jauh lebih baik jika adanya penambahan input validation, input sanitation, dan error handling yang baik dan informatif terhadap developer program terkait.
