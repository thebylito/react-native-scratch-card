using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Scratch.Card.RNScratchCard
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNScratchCardModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNScratchCardModule"/>.
        /// </summary>
        internal RNScratchCardModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNScratchCard";
            }
        }
    }
}
