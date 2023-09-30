<template>
    <div>
      <label for="phoneNumber">Telefon numarası:</label>
      <input type="text" id="phoneNumber" v-model="searchPhoneNumber" />
      <button @click="searchCustomer">Ara</button>
  
     
      <div v-if="customer">
  <h2>Aradığınız Müşteri:</h2>
  <p>Adı: {{ customer.name }}</p>
  <p>Soyadı: {{ customer.surName }}</p>
  <p>Email: {{ customer.email }}</p>
  <p>Açıklama: {{ customer.explanation }}</p>
  <p>Tarih: {{ customer.date }}</p>
</div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        searchPhoneNumber: "",
        customer: null, 
      };
    },
    methods: {
      searchCustomer() {
        fetch(`http://localhost:8080/v1/register/${this.searchPhoneNumber}`)
          .then((response) => {
            if (response.status === 200) {
              return response.json();
            } else {
              throw new Error("Müşteri bulunamadı");
            }
          })
          .then((data) => {
            this.customer = data;
          })
          .catch((error) => {
            console.error("Hata:", error.message);
            this.customer = null; 
          });
      },
    },
  };
  </script>
  
  <style scoped>
  </style>
  