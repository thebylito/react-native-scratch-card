
import React, { Component } from 'react'
import { requireNativeComponent, ViewPropTypes, NativeModules, DeviceEventEmitter } from 'react-native';
import PropTypes from 'prop-types'

const { RNScratchCard } = NativeModules;
const iface = {
  name: 'RNScratchCardManager',
  propTypes: {
    color: PropTypes.string,
    ...ViewPropTypes
  }
};

const RCTRNScratchCard = requireNativeComponent('RNScratchCardManager', iface);

class RNScratchCardView extends Component {
  state = { ready: true }
  componentDidMount = () => {
    DeviceEventEmitter.addListener('percentEv', this.listem)
  }

  listem = (data) => {
    const { ready } = this.state;
    this.props.getPercent(data.value)
    if (data.value >= this.props.maxPercent) {

      if (ready) {
        this.setState({ ready: false }, () => {
          this.props.onEnd()
        })
      }
    }
    if (data.value >= 100) {
      DeviceEventEmitter.removeAllListeners()
    }
  }

  componentWillUnmount = () => {
    DeviceEventEmitter.removeAllListeners()
  }

  render() {
    return <RCTRNScratchCard ref={myView => { this.myView = myView }} {...this.props} />
  }
}

export default RNScratchCardView;
export { RNScratchCard };





















