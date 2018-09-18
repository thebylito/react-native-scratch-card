
# react-native-scratch-card

## Getting started

`$ npm install react-native-scratch-card --save`

### Mostly automatic installation

`$ react-native link react-native-scratch-card`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-scratch-card` and add `RNScratchCard.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNScratchCard.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNScratchCard.sln` in `node_modules/react-native-scratch-card/windows/RNScratchCard.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Scratch.Card.RNScratchCard;` to the usings at the top of the file
  - Add `new RNScratchCardPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNScratchCard from 'react-native-scratch-card';

// TODO: What to do with the module?
RNScratchCard;
```
  