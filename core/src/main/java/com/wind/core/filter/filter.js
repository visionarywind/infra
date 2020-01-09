/*
* filter: (req, service) => rep
* > filter & filter : filter
* > filter & service : service
*
* >> filter & filter & service : service
* */

function Filter(flow) {
  return (channel => ({
      and: next => Filter((req, srv) => channel(req, next.then(srv))),
      then: srv => req => channel(req, srv)
  }))(flow);
}

function FilterOrigin(flow) {
  class _Inner {
    constructor(ch) {
      this._ch = ch;
    }
    and = next => {
      const self = this;
      return (new FilterOrigin((req, srv) => self._ch(req, next.then(srv))));
    };
    then = req => {
      const self = this;
      return (self._ch(req, srv));
    };
  };

  return new _Inner(flow);
}
