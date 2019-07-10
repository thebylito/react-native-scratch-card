## react-native-scratch-card (Android Only)

#### Thanks for https://github.com/D-clock/ScratchView/

<center>
<img style="align:center" src="preview.gif" height="600">
</center>

## Installation

<details>
<summary>react-native >= 0.60.0</summary>

### 1 - Install the package:

`$ yarn add react-native-scratch-card`

or

`$ npm install react-native-scratch-card --save`

### 2 - Edit yout `"AndroidManifest.xml"` in `"android/app/src/main/"`

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  package="com.myawesomeapp"
  xmlns:tools="http://schemas.android.com/tools" <!-- Add this line -->
  ...
  >
```

### and

```xml
<application
      android:name=".MainApplication"
      android:label="@string/app_name"
      android:icon="@mipmap/ic_launcher"
      android:roundIcon="@mipmap/ic_launcher_round"
      android:allowBackup="false"
      tools:replace="android:allowBackup" <!-- Add this line -->
        ...
```

## That's is all!

</details>
<details>
<summary>react-native <= 0.59.0</summary>

### 1 - Install the package:

### Mostly automatic installation

`$ yarn add react-native-scratch-card`

`$ react-native link react-native-scratch-card`

or

`$ npm install react-native-scratch-card --save`

`$ react-native link react-native-scratch-card`

### 2 - Edit yout `"AndroidManifest.xml"` in `"android/app/src/main/"`

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  package="com.myawesomeapp"
  xmlns:tools="http://schemas.android.com/tools" <!-- Add this line -->
  ...
  >
```

### and

```xml
<application
      android:name=".MainApplication"
      android:label="@string/app_name"
      android:icon="@mipmap/ic_launcher"
      android:roundIcon="@mipmap/ic_launcher_round"
      android:allowBackup="false"
      tools:replace="android:allowBackup" <!-- Add this line -->
        ...
```

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`

- Add `import com.thebylito.RNScratchCardPackage;` to the imports at the top of the file
- Add `new RNScratchCardPackage()` to the list returned by the `getPackages()` method

2. Append the following lines to `android/settings.gradle`:
   ```
   include ':react-native-scratch-card'
   project(':react-native-scratch-card').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-scratch-card/android')
   ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
   ```
     compile project(':react-native-scratch-card')
   ```
   </details>

## Example

```javascript
import React, { Component } from "react";
import { StyleSheet, Text, View, Image, Alert } from "react-native";
import ScratchCard from "react-native-scratch-card";

export default class App extends Component {
  state = { color: "red", status: 0 };
  render() {
    return (
      <View style={styles.container}>
        <Text>{this.state.status}</Text>
        <ScratchCard
          brushSize={125}
          getPercent={percent => {
            this.setState({ status: percent });
          }}
          onEnd={() => {
            Alert.alert("acabou!");
          }}
          maxPercent={50}
          style={{
            justifyContent: "center",
            alignItems: "center",
            width: 400,
            height: 400
          }}
          color={"gray"}
        >
          <Text style={{ fontSize: 20 }}>Hello World!!!</Text>
        </ScratchCard>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF"
  }
});
```
