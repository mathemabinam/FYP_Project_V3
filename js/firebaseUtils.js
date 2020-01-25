'use strict';

(function() {
  class FirebaseUtils {
    constructor(config) {
      this.initializeApp(config);
      this.setAuthPersistence();
  
      this.storage      = this.getStorage();
      this.database     = this.getDatabase();
      this.auth         = this.getAuth();
    }
  
    initializeApp(config) {
      firebase.initializeApp(config);
    }
  
    setAuthPersistence() {
      firebase.auth.Auth.Persistence.LOCAL;
    }
  
    getStorage() {
      return firebase.storage();
    }
  
    getDatabase() {
      return firebase.database();
    }

    getAuth() {
      return firebase.auth();
    }

    login = async (email, password) => await this.auth.signInWithEmailAndPassword(email, password)

    logout = async () => await this.auth.signOut()

    isLoggedIn = () => {
      return new Promise((resolve, reject) => {
        this.auth.onAuthStateChanged(user => {
          if (user) {
            resolve(user);
          } else {
            reject();
          }
        });
      });
    }
  
    uploadFile = async (bucket, file, name) => {
      const extension     = file.name.split('.').slice('-1')[0];
      const fileName       = name || `${uuid()}.${extension}`;
      const storageRef    = this.storage.ref(`/${bucket}/${fileName}`);
      const snapshot      = await storageRef.put(file);

      return snapshot.metadata.fullPath;
    }
  
    insert = async (collection, data) => {
      const databaseRef = await this.database.ref(`${collection}`).push();
      const id          = databaseRef.key;
      
      await databaseRef.set(data);
      return { ...data, id };
    }

    update = async (collection, id, data) => {
      const databaseRef   = this.database.ref(`${collection}/${id}`);
      const existingData  = await this.get(collection, id);
      const payload       = { ...existingData, ...data };
      
      await databaseRef.set(payload);
      return payload;
    }

    listAll = async (collection) => {
      const snapshot = await this.database.ref(`${collection}`).once('value');
      const list     = snapshot.val();
      return Object.values(list)
        .map((item, k) => (
          { ...item, id: Object.keys(list)[k] }
        ));
    }

    get = async (collection, id) => {
      const snapshot = await this.database.ref(`${collection}/${id}`).once('value');
      return snapshot.val();
    }
  }
  
  const config = {
    apiKey: "AIzaSyBfAiv3e-9SwsdgN2Ey2Hrdi6dt-P7RMCM",
    authDomain: "fypcatalog-ca80c.firebaseapp.com",
    databaseURL: "https://fypcatalog-ca80c.firebaseio.com",
    projectId: "fypcatalog-ca80c",
    storageBucket: "fypcatalog-ca80c.appspot.com",
    messagingSenderId: "900761097193",
    appId: "1:900761097193:web:df6d13bfe738e77514f178"
  };

  window.firebaseUtils = new FirebaseUtils(config);

})();



