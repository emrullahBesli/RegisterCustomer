<template>
  <div>
    <h2>Add Customer</h2>
    <form @submit.prevent="addCustomer" class="row">
      <div class="col-md-6">
        <div class="mb-3">
          <label for="name" class="form-label">Name:</label>
          <input type="text" id="name" class="form-control" v-model="customer.name" />
        </div>
        <div class="mb-3">
          <label for="surname" class="form-label">Surname:</label>
          <input type="text" id="surname" class="form-control" v-model="customer.surname" />
        </div>
        <div class="mb-3">
          <label for="phoneNumber" class="form-label">Phone Number:</label>
          <input type="text" id="phoneNumber" class="form-control" v-model="customer.phoneNumber" />
        </div>
      </div>
      <div class="col-md-6">
        <div class="mb-3">
          <label for="email" class="form-label">Email:</label>
          <input type="email" id="email" class="form-control" v-model="customer.email" />
        </div>
        <div class="mb-3">
          <label for="explanation" class="form-label">Description:</label>
          <textarea id="explanation" class="form-control" v-model="customer.explanation"></textarea>
        </div>
      </div>
      <div class="col-md-12">
        <button type="submit" class="btn btn-primary">Add Customer</button>
      </div>
    </form>
    <!-- Hata mesajını göster -->
    <div v-if="errorMessage" class="alert alert-danger">
      {{ errorMessage }}
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      customer: {
        name: "",
        surname: "",
        phoneNumber: "",
        email: "",
        explanation: "",
      },
      errorMessage: "", // Hata mesajı
    };
  },
  methods: {
    addCustomer() {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify({
        "name": this.customer.name,
        "surName": this.customer.surname,
        "phoneNumber": this.customer.phoneNumber,
        "email": this.customer.email,
        "explanation": this.customer.explanation
      });

      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        mode: 'cors',
        body: raw,
        redirect: 'follow'
      };

      fetch("http://localhost:8080/v1/register", requestOptions)
        .then(response => {
          if (response.status === 200) {
            return response.text();
          } else {
            return response.text().then(errorMessage => {
              this.errorMessage = errorMessage;
              throw new Error(errorMessage);
            });
          }
        })
        .then(result => {
          console.log(result);
          alert("Kayıt alındı");
          this.errorMessage = "";
          window.location.reload();
        })
        .catch(error => {
          console.log('error', error)
          this.errorMessage = error.message;
        });
    },
  },
};
</script>
